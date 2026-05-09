import { Routes, Route, Navigate} from "react-router-dom";
import Products from "./pages/products/Products";
import ProductDetails from "./components/product-details/ProductDetails";
import NotFound from "./components/not-found/NotFound";
import NavBar from "./components/nav-bar/NavBar";

export default function App() {
  return (

    <Routes>
      <Route  path="/" element={<Navigate to="/products" />}/>
      <Route  path="/products" element={<Products/>}/>
      <Route path="/products/:id" element={<ProductDetails/>}/>
      <Route path="*" element={<NotFound/>}/>
    </Routes>
  )
}