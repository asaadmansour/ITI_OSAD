import { Routes, Route, Navigate} from "react-router-dom";
import Products from "./pages/products/Products";
import ProductDetails from "./components/product-details/ProductDetails";
import NotFound from "./components/not-found/NotFound";
import NavBar from "./components/nav-bar/NavBar";
import Cart from "./pages/cart/Cart";
import { LanguageProvider } from "./contexts/languageContext";
import Register from "./pages/register/register";
import ContactUs from "./pages/contact-us/ContactUs";
import ProtectedRoute from "./components/protected-route/ProtectedRoute";

export default function App() {
  return (
    <LanguageProvider>
      <Routes>
        <Route  path="/" element={<Navigate to="/products" />}/>
        <Route  path="/products" element={<ProtectedRoute><Products/></ProtectedRoute>}/>
        <Route  path="/cart" element={<ProtectedRoute><Cart/></ProtectedRoute>}/>
        <Route path="/register"element={<Register/>}></Route>
        <Route path="/products/:id" element={<ProductDetails/>}/>
        <Route path="/contactus" element={<ContactUs/>}></Route>
        <Route path="*" element={<NotFound/>}/>

      </Routes>
    </LanguageProvider>
  )
}