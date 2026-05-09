import axios from "axios";
import { useEffect, useState } from "react";
import { useParams } from "react-router-dom";
import NavBar from "../nav-bar/NavBar";

export default function ProductDetails() {
    const {id} = useParams();
    const [product, setProduct] = useState("");
    const [isLoading, setIsLoading] = useState(true);

    useEffect(() => {
        setIsLoading(true);
        axios.get(`https://dummyjson.com/products/${id}`)
            .then((prod) => setProduct(prod.data))
            .catch((err) => console.error(err))
            .finally(() => setIsLoading(false))
    }, [id])
  if (isLoading) return (
    <>
      <NavBar />
      <div className="min-h-screen flex items-center justify-center">
        <div className="w-12 h-12 border-4 border-indigo-500 border-t-transparent rounded-full animate-spin"></div>
      </div>
    </>
  );

  return (
    <>
    <NavBar/>
    <div className="min-h-screen bg-gray-50 flex items-center justify-center p-8">
      <div className="bg-white rounded-2xl shadow-md overflow-hidden max-w-4xl w-full grid grid-cols-1 md:grid-cols-2">
        <div className="bg-gray-100 flex items-center justify-center p-10">
          <img
            className="w-full max-w-xs object-contain drop-shadow-md"
            src={product.thumbnail}
            alt="Essence Mascara Lash Princess"
          />
        </div>

        <div className="p-8 flex flex-col gap-4">
          <div className="flex gap-2">
            
            <span className="text-xs font-medium px-2.5 py-1 rounded-full bg-indigo-50 text-indigo-600 border border-indigo-100">
              {product.category}
            </span>
            <span className="text-xs font-medium px-2.5 py-1 rounded-full bg-gray-100 text-gray-500 border border-gray-200">
              {product.brand}
            </span>
          </div>

          <h1 className="text-2xl font-bold text-gray-800 leading-snug">
            {product.title}
          </h1>

          <div className="flex items-center gap-2">
            <div className="flex text-amber-400 text-sm">
              ★★★★<span className="text-gray-300">★</span>
            </div>
            <span className="text-sm text-gray-400">(4.0)</span>
          </div>

          <p className="text-sm text-gray-500 leading-relaxed">
            {product.description}
          </p>

          <div className="flex items-baseline gap-3">
            <span className="text-2xl font-bold text-gray-900">$100</span>
            <span className="text-sm text-gray-400 line-through">$232</span>
            <span className="text-xs font-semibold text-green-600 bg-green-50 px-2 py-0.5 rounded-full">
              {product.discountPercentage}
            </span>
          </div>

          <div className="flex items-center gap-2 text-sm">
            <span className="w-2 h-2 rounded-full bg-green-400 inline-block"></span>
            <span className="text-green-600 font-medium">{product.availabilityStatus}</span>
          </div>

          <div>
            <input
              type="range"
              className="w-full accent-indigo-500 cursor-pointer"
              min={0}
              max={100}
              defaultValue={30}
            />
            <p className="text-xs text-gray-400 mt-1">Only {product.stock} items left!</p>
          </div>

          <div className="flex gap-3 mt-2">
            <button className="flex-1 bg-indigo-600 hover:bg-indigo-700 text-white text-sm font-semibold py-2.5 rounded-xl transition-colors">
              Buy Now
            </button>
            <button className="flex-1 border border-indigo-600 text-indigo-600 hover:bg-indigo-50 text-sm font-semibold py-2.5 rounded-xl transition-colors">
              Add to Cart
            </button>
          </div>

        </div>
      </div>
    </div>
  </>
  );
}