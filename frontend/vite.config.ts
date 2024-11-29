import { defineConfig } from 'vite'
import react from '@vitejs/plugin-react'

// https://vitejs.dev/config/
export default defineConfig(() => {
  console.log(process.env);
  return {plugins: [react()],}
})
  

