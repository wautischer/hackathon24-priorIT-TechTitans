<%@ page import="at.techtitans.hackathon.persistence.FeedbackDAO" %>
<%@ page import="at.techtitans.hackathon.entities.UserFeedback" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="at.techtitans.hackathon.entities.Employee" %>
<%@ page import="at.techtitans.hackathon.entities.Login" %>
<%@ page import="at.techtitans.hackathon.entities.ProjectFeedPack" %>
<!DOCTYPE html>
<html lang="de">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Project</title>
    <!-- Bootstrap CSS -->
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet">
    <!-- Chart.js -->
    <script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
    <!-- FontAwesome CSS for icons -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">
    <style>
        body {
            background-color: #3c3c3b;
            color: white;
        }

        /* Stile für das Overlay */
        .overlay {
            display: none;
            position: fixed;
            top: 0;
            right: 0;
            width: 100%;
            height: 100%;
            background-color: rgba(0, 0, 0, 0.5); /* Halbtransparentes Schwarz */
            z-index: 9999; /* Über allen anderen Inhalten */
            justify-content: center; /* Horizontal zentriert */
            align-items: center; /* Vertikal zentriert */
            padding: 20px; /* Abstand von den Rändern */
        }

        /* Stile für das Popup-Fenster */
        .popup {
            background-color: #3c3c3b;
            padding: 20px;
            border-radius: 5px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.3);
            max-width: 400px; /* Maximale Breite des Popups */
            text-align: center;
            transform: translateY(-50px); /* Startposition für die Animation */
            opacity: 0; /* Startopacity für die Animation */
            transition: transform 0.3s ease-out, opacity 0.3s ease-out; /* Übergangseffekte */
        }

        /* Animation wenn das Popup angezeigt wird */
        .overlay.show .popup {
            transform: translateY(0);
            opacity: 1;
        }

        /* Animation wenn das Popup versteckt wird */
        .overlay.hide .popup {
            transform: translateY(-50px);
            opacity: 0;
        }

        /* Rundes Profil-Icon */
        #profileIcon {
            border-radius: 50%;
            margin-bottom: 20px; /* Abstand unter dem Profil-Icon */
        }

        /* Stil für Login/Logout-Buttons */
        .btn-logout {
            color: white;
            width: 150px; /* Breite der Buttons */
            margin: 0 10px; /* Abstand zwischen den Buttons */
        }

        .btn-logout a {
            color: white;
            text-decoration: none;
        }
    </style>
</head>
<body>
<div class="container-fluid">
    <div class="row">
        <div id="navbar"></div>
        <main role="main" class="col-md-9 ml-sm-auto col-lg-10 px-4">
            <div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3 border-bottom">
                <h1 class="h2">
                    <%
                        session = request.getSession();
                        Employee loggedInEmployee = (Employee) session.getAttribute("loggedInUser");
                        if (loggedInEmployee != null) {
                            out.println("Hallo, " + loggedInEmployee.getFirstname() + " " + loggedInEmployee.getSurname());
                        } else {
                            out.println("Hallo, User");
                        }
                    %>
                </h1>

                <div>
                    <img id="profileIcon" src="https://via.placeholder.com/40" alt="Profile Icon"
                         style="cursor:pointer;">
                </div>
            </div>
            <div class="row justify-content-center">
                <div class="col-md-6">
                    <canvas id="radarChart"></canvas>
                </div>
            </div>
        </main>
    </div>
</div>



<!-- Overlay und Popup -->
<div id="overlay" class="overlay">
    <div class="popup">
        <h4>Benutzerdetails</h4>
        <%
            if (loggedInEmployee == null) {
        %>
        <p><strong>Bitte anmelden</strong></p>
        <%
        } else {
        %>
        <p><strong>Benutzername:</strong> <%= loggedInEmployee.getFirstname() + "_" + loggedInEmployee.getSurname() %>
        </p>
        <p><strong>Telefonnummer:</strong> <%= loggedInEmployee.getPhoneNumber() %>
        </p>
        <p><strong>Adresse:</strong> <%= loggedInEmployee.getStreetAdress() %>
        </p>
        <%
            }
        %>

        <div style="display: flex; justify-content: space-around;">
            <button id="closePopupButton" class="btn btn-secondary btn-logout">close</button>
            <button onclick="function handleClick() {
                <%
                /*
                session = request.getSession();
                session.setAttribute("loggedInUser", null);

                 */
                %>
                    }
                    handleClick()" id="logout" class="btn btn-secondary btn-logout"><% if (loggedInEmployee == null) {out.println("login");}else {out.println("logout");}%></button>
            sessionStorage.clear();
            }
            handleClick()" id="logout" class="btn btn-secondary btn-logout"><% if (loggedInEmployee == null) {
                out.println("login");
            } else {
                out.println("logout");
            }%></button>
        </div>
    </div>
</div>

<!-- Optional JavaScript -->
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.11.0/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script>
    $(document).ready(function () {
        $("#navbar").load("navbar.jsp");
    });

    // Klick-Ereignis für den Logout-Button
    document.getElementById('logout').addEventListener('click', function (event) {
        event.preventDefault(); // Verhindert das Navigieren zur href-URL
        window.location.href = "login.jsp"; // Weiterleitung zur Login-Seite
    });

    let ctx = document.getElementById('radarChart').getContext('2d');

    <%


     // Laden Sie die Bewertungen eines Mitarbeiters
    List<ProjectFeedPack> ratings = FeedbackDAO.getRatingsByProjectID(1);
    Double teamwork = 0.0;
    Double organisation = 0.0;
    Double deadlines = 0.0;

    double counter = FeedbackDAO.countFeedbacksProject(ratings);

    // Berechnen der Durchschnittswerte
    for (ProjectFeedPack rating : ratings) {
        teamwork += (double) rating.getTeamwork() / counter;
        organisation += (double) rating.getOrganisation() / counter;
        deadlines += (double) rating.getDeadlines() / counter;
    }
 %>



    let radarChart = new Chart(ctx, {
        type: 'radar',
        data: {
            labels: ['Teamwork', 'Organisation', 'Deadlines'],
            datasets: [
                {
                    label: 'Feedback',
                    data: [<%= teamwork %>, <%= organisation %>, <%= deadlines %>],
                    backgroundColor: 'rgba(255, 255, 255, 0.2)',
                    borderColor: 'rgba(255, 255, 255, 1)',
                    borderWidth: 1,
                    pointBackgroundColor: 'rgba(255, 255, 255, 1)',
                    pointBorderColor: 'rgba(255, 255, 255, 1)'
                }
            ]
        },
        options: {
            scale: {
                angleLines: {
                    color: 'rgba(255, 255, 255, 1)' // Farbe der Winkel-Linien
                },
                gridLines: {
                    color: 'rgba(255, 255, 255, 1)', // Farbe der Rasterlinien
                    circular: true
                },
                ticks: {
                    beginAtZero: true,
                    suggestedMin: 0,
                    suggestedMax: 5,
                    stepSize: 1,
                    backdropColor: 'rgba(0, 0, 0, 0)',
                    color: 'rgba(255, 255, 255, 1)' // Farbe der Nummerierungen
                },
                pointLabels: {
                    fontColor: 'rgba(255, 255, 255, 1)' // Farbe der Beschriftungen
                }
            },
            legend: {
                labels: {
                    fontColor: 'rgba(255, 255, 255, 1)' // Farbe der Legenden-Beschriftungen
                }
            }
        }

    });


    // Öffnen des Popups beim Klick auf das Profil-Icon
    document.getElementById('profileIcon').addEventListener('click', function () {
        let overlay = document.getElementById('overlay');
        overlay.classList.remove('hide');
        overlay.classList.add('show');
        overlay.style.display = 'flex';
    });

    // Schließen des Popups beim Klick auf den Schließen-Button
    document.getElementById('closePopupButton').addEventListener('click', function () {
        var overlay = document.getElementById('overlay');
        overlay.classList.remove('show');
        overlay.classList.add('hide');
        setTimeout(function () {
            overlay.style.display = 'none';
        }, 300); // Warte bis die Animation abgeschlossen ist
    });
</script>
<%
    if (ratings != null && !ratings.isEmpty()) {
%>
<div class="container">
    <div class="row justify-content-center">
        <div class="col-md-10">
            <div>
                <table class="table table-striped">
                    <thead>
                    <tr>
                        <th>ID</th>
                        <th>Firstname</th>
                        <th>Surname</th>
                        <th>Written Feedback</th>
                    </tr>
                    </thead>
                    <tbody>
                    <% for (ProjectFeedPack u : ratings) { %>
                    <tr>
                        <%
                            Employee employee = FeedbackDAO.getEmployeeByID(u.getIdFrom());
                            String firstname = "anonym";
                            String surname = "anonym";
                            if (employee != null) {
                                firstname = employee.getFirstname();
                                surname = employee.getSurname();
                            }
                        %>
                        <td><%= u.getId() %></td>
                        <td><%= firstname %></td>
                        <td><%= surname %></td>
                        <td><%= u.getInputField() %></td>
                    </tr>
                    <% } %>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</div>
<%}%>

</body>
</html>