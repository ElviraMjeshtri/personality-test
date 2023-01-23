import { fileURLToPath, URL } from 'node:url'

import { defineConfig } from 'vite'
import vue from '@vitejs/plugin-vue'
const PROXY = 'http://localhost:8082';

// https://vitejs.dev/config/
export default defineConfig({
  plugins: [vue()],
  resolve: {
    alias: {
      '@': fileURLToPath(new URL('./src', import.meta.url))
    }
  },
  server:{
    port:4000,
    proxy:{
      '^/api/v1': {
        target: 'http://localhost:8082',
        changeOrigin: true,
      }
    }
  }
})
