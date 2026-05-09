import { StrictMode } from 'react'
import { createRoot } from 'react-dom/client'
import { BrowserRouter } from "react-router-dom";
import { Provider } from 'react-redux';
import { LanguageProvider } from './contexts/languageContext.jsx';
import './index.css'
import App from './App.jsx'
import store from './store/store.js';


createRoot(document.getElementById('root')).render(
  <StrictMode>
    <BrowserRouter>
    <Provider store={store}>
      <LanguageProvider>
        <App />
      </LanguageProvider>
      </Provider>
    </BrowserRouter>
  </StrictMode>
)
