var swiper = new Swiper(".swiper", {
  effect: "coverflow",
  grabCursor: true,
  centeredSlides: true,
  coverflowEffect: {
    rotate: 0,
    stretch: 0,
    depth: 200,
    modifier: 3,
    slideShadows: true
  },
  loop: true,
  pagination: {
    el: ".swiper-pagination",
    clickable: true
  },
  slidesPerView: 2,
  autoplay: {
    delay: 3000,
    disableOnInteraction: false
  }
});

var swiper2 = new Swiper(".mySwiper", {
  slidesPerView: 5,
  spaceBetween: 15,
  slidesPerGroup: 5,
  loop: true,
  loopFillGroupWithBlank: true,
  speed: 1000,
  navigation: {
    nextEl: ".swiper-button-next",
    prevEl: ".swiper-button-prev",
  },
});