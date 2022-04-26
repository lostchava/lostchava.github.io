const container = document.querySelector(".container")
const icons = [
  { name: "icon192", image: "Icon-192.png" },
  { name: "icon256", image: "Icon-256.png" },
  { name: "icon384", image: "Icon-384.png" },
  { name: "icon512", image: "Icon-512-1.png" },
  { name: "lightbulueBG", image: "lightblue.jpg" },
  { name: "lightgoldBG", image: "lightgold.jpg" },
]


if ("serviceWorker" in navigator) {
    window.addEventListener("load", function() {
      navigator.serviceWorker
        .register("./serviceWorker.js")
        .then(res => console.log("service worker registered"))
        .catch(err => console.log("service worker not registered", err))
    })
  }