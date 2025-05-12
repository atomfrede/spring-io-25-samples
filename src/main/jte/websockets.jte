<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="color-scheme" content="light dark">
    <link rel="stylesheet" href="webjars/picocss__pico/2.1.1/css/pico.min.css">
    <script src="webjars/htmx.org/2.0.4/dist/htmx.min.js"></script>
    <script src="https://unpkg.com/htmx-ext-ws@2.0.2" crossorigin="anonymous"></script>
    <script src="https://unpkg.com/idiomorph@0.7.3" integrity="sha384-JcorokHTL/m+D6ZHe2+yFVQopVwZ+91GxAPDyEZ6/A/OEPGEx1+MeNSe2OGvoRS9" crossorigin="anonymous"></script>
    <script src="https://unpkg.com/idiomorph@0.7.3/dist/idiomorph-ext.min.js" integrity="sha384-szktAZju9fwY15dZ6D2FKFN4eZoltuXiHStNDJWK9+FARrxJtquql828JzikODob" crossorigin="anonymous"></script>
    <title>JDConf 2025 Samples</title>
</head>
<body hx-ext="morph">
<header class="container">
    @template.nav()
</header>
<main class="container">
    <ul hx-ext="ws" ws-connect="/websockets/ws" id="news-feed">

    </ul>
</main>
</body>
</html>