<%@page contentType="text/html" pageEncoding="UTF-8"%> 
<!doctype html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Welcome  <%= request.getAttribute("name") %></title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
  </head>
  <style>
    body{
        margin: 0;
        padding: 0;
        height: 100%;
        background-image: url('welcome_bg.png'); 
        background-size: cover;  
        background-position: center; 
        background-repeat: no-repeat;
        background-attachment: fixed; /* Optional: Fix the background image */
        width: 100%;
        height: 100vh;   
        overflow: hidden;
        color: aliceblue;
        text-align: center;
    }
    .welcome-heading{
      display: inline-block;
    }
  </style>
  <body>
    <div class="d-flex justify-content-center">
      <div class="d-flex flex-column mb-3">
        <div class="p-2">
          <p class="welcome-heading fs-1 fw-bolder">Welcome <br> <%= request.getAttribute("name") %></p>
        </div>
        <div class="p-2">
          <p class="typeAnimation fw-bolder fs-3"></p>
        </div>
        <!-- <div class="p-2">Flex item 3</div> -->
      </div>
    </div>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/typed.js@2.0.11/lib/typed.min.js"></script>
    <script>
      const tag_lines = ["Where Every Meal is a Celebration",
      "Flavors That Dance on Your Palate",
      "Culinary Delights, Crafted with Love",
      "A Symphony of Taste in Every Bite",
      "Savor the Extraordinary",
      "Where Passion Meets Plate",
      "Your Taste Journey Begins Here",
      "Indulge in Perfection",
      "Crafting Memories, One Dish at a Time",
      "A Feast for the Senses"]

      const typed = new Typed('.typeAnimation', {
        strings: tag_lines,
        typeSpeed: 40,
        backSpeed: 20,
        loop: true
      });

    </script>
  </body>
</html>