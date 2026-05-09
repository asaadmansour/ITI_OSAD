import { Routes, Route, Navigate} from "react-router-dom";
import Products from "./pages/products/Products";
import ProductDetails from "./components/product-details/ProductDetails";
import NotFound from "./components/not-found/NotFound";
import NavBar from "./components/nav-bar/NavBar";
import Cart from "./pages/cart/Cart";
import { LanguageProvider } from "./contexts/languageContext";

export default function App() {
  return (
    <LanguageProvider>
      <Routes>
        <Route  path="/" element={<Navigate to="/products" />}/>
        <Route  path="/products" element={<Products/>}/>
        <Route  path="/cart" element={<Cart/>}/>
        <Route path="/products/:id" element={<ProductDetails/>}/>
        <Route path="*" element={<NotFound/>}/>
      </Routes>
    </LanguageProvider>
  )
}