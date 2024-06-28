<!DOCTYPE html>
<html lang="de">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Feedback</title>
    <style>
        body {
            margin: 0;
            font-family: Arial, sans-serif;
            background-color: #333;
            color: white;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }

        .feedback-container {
            background: #444;
            padding: 40px;
            border-radius: 8px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            width: 400px;
            text-align: center;
            position: relative;
            display: flex;
            flex-direction: column;
            align-items: center; /* Zentriert Elemente horizontal */
        }

        .feedback-header {
            display: flex;
            justify-content: space-between;
            align-items: center;
            width: 100%;
            margin-bottom: 20px; /* Abstand unterhalb des Headers */
        }

        .user-profile {
            cursor: pointer;
        }

        .user-profile img {
            width: 40px;
            height: 40px;
            border-radius: 50%;
        }

        .user-info {
            display: none;
            position: absolute;
            top: 50px; /* Anpassen der Position */
            right: 20px;
            background: #555;
            padding: 20px;
            border-radius: 8px;
            width: 200px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
        }

        .user-info p {
            margin: 10px 0;
        }

        .feedback-container h2 {
            margin-bottom: 20px;
            color: white;
        }

        .input-field, .text-input-field, .select-field {
            width: 100%;
            padding: 10px;
            margin: 10px 0;
            border: 1px solid #888;
            border-radius: 4px;
            box-sizing: border-box;
            background: #555;
            color: white;
        }

        .stars {
            display: flex;
            justify-content: center;
            direction: rtl; /* Textausrichtung von rechts nach links */
        }

        .stars input[type="radio"] {
            display: none;
        }

        .stars label {
            font-size: 2em;
            color: gray; /* Standardfarbe Grau */
            cursor: pointer;
            transition: color 0.3s; /* Übergangseffekt für Farbänderung */
        }

        .stars input[type="radio"]:checked ~ label {
            color: #a6233b; /* Farbe Rot für ausgewählte Sterne */
        }

        .stars input[type="radio"]:hover ~ label,
        .stars input[type="radio"]:hover ~ label ~ label {
            color: #a6233b; /* Farbe Rot bei Hover */
        }

        .submit-btn {
            width: 100%;
            padding: 10px;
            background-color: #a6233b;
            color: white;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            font-size: 16px;
            margin-top: 20px; /* Abstand nach unten */
        }

        .submit-btn:hover {
            background-color: #a30026;
        }

        .checkbox-container {
            display: flex;
            align-items: center;
            justify-content: center;
        }

        .checkbox-container input {
            margin-right: 10px;
        }

        .checkbox-container input[type="checkbox"]:checked::before {
            content: '';
            position: absolute;
            top: 2px;
            left: 2px;
            width: 12px;
            height: 12px;
            background-color: #a6233b;
            border-radius: 2px;
        }

    </style>
</head>
<body>
<div class="feedback-container">
    <div class="feedback-header">
        <button onclick="window.location.href='index.jsp'" class="btn btn-danger btn-sm float-left mb-3"><i
                class="fas fa-arrow-left"></i> Back
        </button>
        <h2>Feedback</h2>
        <div class="user-profile" onclick="toggleUserInfo()">
            <img src="https://via.placeholder.com/40" alt="User">
        </div>
    </div>
    <div class="user-info" id="user-info">
        <p>Name: Max Mustermann</p>
        <p>Email: max@beispiel.com</p>
    </div>
    <form action="feedback" method="get">
        <select class="select-field" name="recipient">
            <option value="">Wählen Sie einen Empfänger</option>
            <option value="user1">Benutzer 1</option>
            <option value="user2">Benutzer 2</option>
        </select>
        <div class="feedback-field">
            <label>Work Performance:</label>
            <div class="stars">
                <input type="radio" id="performance5" name="performance" value="5"><label
                    for="performance5">&#9733;</label>
                <input type="radio" id="performance4" name="performance" value="4"><label
                    for="performance4">&#9733;</label>
                <input type="radio" id="performance3" name="performance" value="3"><label
                    for="performance3">&#9733;</label>
                <input type="radio" id="performance2" name="performance" value="2"><label
                    for="performance2">&#9733;</label>
                <input type="radio" id="performance1" name="performance" value="1"><label
                    for="performance1">&#9733;</label>
            </div>
        </div>
        <div class="feedback-field">
            <label>Knowledge:</label>
            <div class="stars">
                <input type="radio" id="knowledge5" name="knowledge" value="5"><label for="knowledge5">&#9733;</label>
                <input type="radio" id="knowledge4" name="knowledge" value="4"><label for="knowledge4">&#9733;</label>
                <input type="radio" id="knowledge3" name="knowledge" value="3"><label for="knowledge3">&#9733;</label>
                <input type="radio" id="knowledge2" name="knowledge" value="2"><label for="knowledge2">&#9733;</label>
                <input type="radio" id="knowledge1" name="knowledge" value="1"><label for="knowledge1">&#9733;</label>
            </div>
        </div>
        <div class="feedback-field">
            <label>Communication:</label>
            <div class="stars">
                <input type="radio" id="communication5" name="communication" value="5"><label for="communication5">&#9733;</label>
                <input type="radio" id="communication4" name="communication" value="4"><label for="communication4">&#9733;</label>
                <input type="radio" id="communication3" name="communication" value="3"><label for="communication3">&#9733;</label>
                <input type="radio" id="communication2" name="communication" value="2"><label for="communication2">&#9733;</label>
                <input type="radio" id="communication1" name="communication" value="1"><label for="communication1">&#9733;</label>
            </div>
        </div>
        <div class="feedback-field">
            <label>Reliability:</label>
            <div class="stars">
                <input type="radio" id="reliability5" name="reliability" value="5"><label
                    for="reliability5">&#9733;</label>
                <input type="radio" id="reliability4" name="reliability" value="4"><label
                    for="reliability4">&#9733;</label>
                <input type="radio" id="reliability3" name="reliability" value="3"><label
                    for="reliability3">&#9733;</label>
                <input type="radio" id="reliability2" name="reliability" value="2"><label
                    for="reliability2">&#9733;</label>
                <input type="radio" id="reliability1" name="reliability" value="1"><label
                    for="reliability1">&#9733;</label>
            </div>
        </div>
        <div class="feedback-field">
            <label>Teamwork:</label>
            <div class="stars">
                <input type="radio" id="teamwork5" name="teamwork" value="5"><label for="teamwork5">&#9733;</label>
                <input type="radio" id="teamwork4" name="teamwork" value="4"><label for="teamwork4">&#9733;</label>
                <input type="radio" id="teamwork3" name="teamwork" value="3"><label for="teamwork3">&#9733;</label>
                <input type="radio" id="teamwork2" name="teamwork" value="2"><label for="teamwork2">&#9733;</label>
                <input type="radio" id="teamwork1" name="teamwork" value="1"><label for="teamwork1">&#9733;</label>
            </div>
        </div>
        <div class="feedback-field">
            <label>Adability:</label>
            <div class="stars">
                <input type="radio" id="adability5" name="adability" value="5"><label for="adability5">&#9733;</label>
                <input type="radio" id="adability4" name="adability" value="4"><label for="adability4">&#9733;</label>
                <input type="radio" id="adability3" name="adability" value="3"><label for="adability3">&#9733;</label>
                <input type="radio" id="adability2" name="adability" value="2"><label for="adability2">&#9733;</label>
                <input type="radio" id="adability1" name="adability" value="1"><label for="adability1">&#9733;</label>
            </div>
        </div>
        <%
            if (1 == 1) {
        %>
        <div class="feedback-field">
            <label>Leadership:</label>
            <div class="stars">
                <input type="radio" id="leadership5" name="leadership" value="5"><label
                    for="leadership5">&#9733;</label>
                <input type="radio" id="leadership4" name="leadership" value="4"><label
                    for="leadership4">&#9733;</label>
                <input type="radio" id="leadership3" name="leadership" value="3"><label
                    for="leadership3">&#9733;</label>
                <input type="radio" id="leadership2" name="leadership" value="2"><label
                    for="leadership2">&#9733;</label>
                <input type="radio" id="leadership1" name="leadership" value="1"><label
                    for="leadership1">&#9733;</label>
            </div>
        </div>
        <%
            }
        %>
        <div class="feedback-field">
            <label for="feedback">Feedback:</label>
            <textarea id="feedback" placeholder="Geben Sie Ihr Feedback ein..." name="feedback" rows="4"
                      cols="50"></textarea>
        </div>
        <div class="feedback-field">
            <input type="checkbox" id="anonymous" name="anonymous" checked>
            <label for="anonymous">Anonym absenden</label>
        </div>
        <input type="submit" class="submit-btn" value="Absenden">
    </form>
</div>

<script>
    function toggleUserInfo() {
        var userInfo = document.getElementById('user-info');
        if (userInfo.style.display === 'none' || userInfo.style.display === '') {
            userInfo.style.display = 'block';
        } else {
            userInfo.style.display = 'none';
        }
    }
</script>
</body>
</html>
