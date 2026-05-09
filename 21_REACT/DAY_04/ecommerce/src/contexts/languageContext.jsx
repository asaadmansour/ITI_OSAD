import { createContext, useState } from "react";

const LanguageContext = createContext();

export function LanguageProvider({ children }) {  
  const [language, setLanguage] = useState("en");

  const changeLanguage = (lang) => setLanguage(lang);

  return (
    <LanguageContext.Provider value={{ language, changeLanguage }}>
      {children}
    </LanguageContext.Provider>
  );
}

export default LanguageContext; 