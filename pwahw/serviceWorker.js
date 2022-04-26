// const progressiveWebApplication = "PWA-v1"
// const assets = [
//   "/styles.css",
//   "/app.js",
// ]

// self.addEventListener("install", installEvent => {
//   installEvent.waitUntil(
//     caches.open(progressiveWebApplication).then(cache => {
//       cache.addAll(assets)
//     })
//     )
//   })
//   self.addEventListener("fetch", fetchEvent => {
//     fetchEvent.respondWith(
//       caches.match(fetchEvent.request).then(res => {
//         return res || fetch(fetchEvent.request)
//       })
//       )
//     })
    var CACHE_VERSION = 'PWA-v1';
    var CACHE_FILES = [
      "index.html",
      'app.js',
      'styles.css',
      "Icon-192.png",
      "Icon-256.png",
      "Icon-384.png",
      "Icon-512-1.png",
      "lightblue.jpg",
      "lightgold.jpg",
  ];
  
  self.addEventListener('install', event => {
      console.log('SW installed');
      event.waitUntil(
          caches
          .open(CACHE_VERSION)
          .then(cache => {
              console.log('SW caching files');
              cache.addAll(CACHE_FILES)
          })
          .then(() => self.skipWaiting())
      );
  });
  
  self.addEventListener('activate', event => {
      console.log('SW activated');
      event.waitUntil(
          caches.keys().then(keyNames => {
              return Promise.all(
                  keyNames.map(key => {
                      if(key !== CACHE_VERSION) {
                          console.log('SW clearing old caches');
                          return caches.delete(key);
                      }
                  })
              );
          })
      );
  });
  
  self.addEventListener('fetch', event => {
      console.log('SW fetching');
      event.respondWith(
          fetch(event.request).catch(() => caches.match(event.request))
      );
  });  