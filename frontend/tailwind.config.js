/** @type {import('tailwindcss').Config} */
module.exports = {
    content: [
        "./src/**/*.{vue,js}",
    ],
    darkMode: 'class',
    theme: {
        extend: {
            backgroundImage: {
                'img-background': "url('/public/img2.jpg')"
            },
            colors: {
                primary: {
                    "50": "#fdf2f8",
                    "100": "#fce7f3",
                    "200": "#fbcfe8",
                    "300": "#f9a8d4",
                    "400": "#f472b6",
                    "500": "#ec4899",
                    "600": "#db2777",
                    "700": "#be185d",
                    "800": "#9d174d",
                    "900": "#831843"
                }
            }
        },
        fontFamily: {
            'body': [
                'Inter',
                'ui-sans-serif',
                'system-ui',
                '-apple-system',
                'system-ui',
                'Segoe UI',
                'Roboto',
                'Helvetica Neue',
                'Arial',
                'Noto Sans',
                'sans-serif',
                'Apple Color Emoji',
                'Segoe UI Emoji',
                'Segoe UI Symbol',
                'Noto Color Emoji'
            ],
            'sans': [
                'Inter',
                'ui-sans-serif',
                'system-ui',
                '-apple-system',
                'system-ui',
                'Segoe UI',
                'Roboto',
                'Helvetica Neue',
                'Arial',
                'Noto Sans',
                'sans-serif',
                'Apple Color Emoji',
                'Segoe UI Emoji',
                'Segoe UI Symbol',
                'Noto Color Emoji'
            ]
        }
    },
    plugins: [],
}
