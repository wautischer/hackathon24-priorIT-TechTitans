<!DOCTYPE html>
<html lang="de">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Home</title>
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
        .btn-login {
            color: white;
            width: 150px; /* Breite der Buttons */
            margin: 0 10px; /* Abstand zwischen den Buttons */
        }

        .btn-login a {
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
                <h1 class="h2">Hallo User</h1>
                <div>
                    <img id="profileIcon" src="https://via.placeholder.com/40" alt="Profile Icon" style="cursor:pointer;">
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
        <p><strong>Benutzername:</strong> Maill</p>
        <p><strong>E-Mail:</strong> mail@beispiel.de</p>
        <p><strong>Adresse:</strong> test 123, 12345 test</p>
        <div style="display: flex; justify-content: space-around;">
            <button id="closePopupButton" class="btn btn-secondary btn-login">close</button>
            <button id="login" class="btn btn-secondary btn-login">login</button>
        </div>
    </div>
</div>

<!-- Optional JavaScript -->
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.11.0/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script>
    $(document).ready(function(){
        $("#navbar").load("navbar.jsp");
    });


    let isLoggedIn = false; // Beispiel für den Einlogstatus

    // Funktion zur Aktualisierung des Login-Buttons
    function updateLoginButton() {
        let loginButton = document.getElementById('login');
        if (isLoggedIn) {
            loginButton.innerHTML = 'logout';
        } else {
            loginButton.innerHTML = 'login';
        }
    }

    // Initialisierung der Funktion beim Laden der Seite
    updateLoginButton();

    let ctx = document.getElementById('radarChart').getContext('2d');
    let radarChart = new Chart(ctx, {
        type: 'radar',
        data: {
            labels: ['Punkt 1', 'Punkt 2', 'Punkt 3', 'Punkt 4', 'Punkt 5', 'Punkt 6','Punkt 7'],
            datasets: [
                {
                    label: 'Feedback',
                    data: [0, 1, 2, 3, 4, 5, 4],
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
                    min: 0,
                    max: 5,
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
    document.getElementById('profileIcon').addEventListener('click', function() {
        let overlay = document.getElementById('overlay');
        overlay.classList.remove('hide');
        overlay.classList.add('show');
        overlay.style.display = 'flex';
    });

    // Schließen des Popups beim Klick auf den Schließen-Button
    document.getElementById('closePopupButton').addEventListener('click', function() {
        var overlay = document.getElementById('overlay');
        overlay.classList.remove('show');
        overlay.classList.add('hide');
        setTimeout(function() {
            overlay.style.display = 'none';
        }, 300); // Warte bis die Animation abgeschlossen ist
    });

    document.getElementById('login').addEventListener('click', function(event) {
        event.preventDefault(); // Verhindert das Navigieren zur href-URL
        isLoggedIn = !isLoggedIn; // Wechselt den Einlogstatus
        updateLoginButton(); // Aktualisiert den Login-Button entsprechend
    });
</script>
</body>
</html>
