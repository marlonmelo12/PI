import React from 'react'
import ReactDOM from 'react-dom/client'
import App from './App.tsx'


import {
  createBrowserRouter,
  RouterProvider
} from 'react-router-dom'

import Login from './routes/Login.tsx'
import Registrar from './routes/Registrar.tsx'
import Home from './routes/Home.tsx'
import { QueryClient, QueryClientProvider } from '@tanstack/react-query'

const router = createBrowserRouter([
  {
    path: "/",
    element: <App/>,
    children: [
      {
        path: "/",
        element: <Home/>
      },
      {
        path: "login",
        element: <Login/>,
      },
      {
        path: "registrar",
        element: <Registrar/>,
      },
    ]
  }
])

const queryClient = new QueryClient();

ReactDOM.createRoot(document.getElementById('root')!).render(
  <React.StrictMode>
    <QueryClientProvider client={queryClient}>
      <RouterProvider router={router}/>
    </QueryClientProvider>
  </React.StrictMode>,
)
