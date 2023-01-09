/** @type {import('tailwindcss').Config} */
module.exports = {
  content: [
    "./src/**/*.{vue,js}",
  ],
  theme: {
    extend: {
      backgroundImage: {
        'img-background': "url('/public/img2.jpg')"
      },
    },
  },
  plugins: [],
}
