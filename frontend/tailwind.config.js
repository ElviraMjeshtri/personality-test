/** @type {import('tailwindcss').Config} */
module.exports = {
  content: [
    "./src/**/*.{vue,js}",
  ],
  theme: {
    extend: {
      backgroundImage: {
        'img1': "url('/public/img2.jpg')"
      },
    },
  },
  plugins: [],
}
