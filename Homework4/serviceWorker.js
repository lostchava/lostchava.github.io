const progressiveWebApplication = "PWA-v1"
const assets = [
  "/",
  "./index.html",
  "./style.css",
  "./app.js",
  "./Icon-192.png",
  "./Icon-256.png",
  "./Icon-384.png",
  "./Icon-512-1.png",
  "./lightblue.jpg",
  "./lightgold.jpg",
]

self.addEventListener("install", installEvent => {
  installEvent.waitUntil(
    caches.open(progressiveWebApplication).then(cache => {
      cache.addAll(assets)
    })
  )
})
self.addEventListener("fetch", fetchEvent => {
    fetchEvent.respondWith(
      caches.match(fetchEvent.request).then(res => {
        return res || fetch(fetchEvent.request)
      })
    )
  })
  