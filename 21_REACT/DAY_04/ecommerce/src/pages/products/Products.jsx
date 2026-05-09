import NavBar from "../../components/nav-bar/NavBar";

import { useEffect, useState } from "react";
import axios from "axios";
import ProductCard from "../../components/product-card/ProductCard";
import { useDispatch } from "react-redux";
const LIMIT = 12;

export default function Products() {
    const [page, setPage] = useState(1);
    const [total, setTotal] = useState(0);
    const [products, setProducts] = useState([]);
    const [isLoading, setIsLoading] = useState(true);
    useEffect(() => {
        setIsLoading(true);
        const skip = (page - 1) * LIMIT;
        axios.get(`https://dummyjson.com/products?limit=${LIMIT}&skip=${skip}`)
             .then((res) => {
                setProducts(res.data.products);
                setTotal(res.data.total);
             })
             .catch((err) => console.error(err))
             .finally(() => setIsLoading(false))
    }, [page])
    const totalPages = Math.ceil(total / LIMIT);

    return (
        <>
        <NavBar/>
        {isLoading ? (
            <div className="min-h-screen flex items-center justify-center">
                <div className="w-12 h-12 border-4 border-blue-500 border-t-transparent rounded-full animate-spin"></div>
            </div>
        ) : (
            <>
            <div className="grid grid-cols-2 md:grid-cols-3 lg:grid-cols-4 gap-6 p-8">
                {products.map((prod) => (
                    <ProductCard key={prod.id} details={prod} />
                ))}
            </div>
            <div className="flex justify-center items-center gap-4 py-6">
                {page > 1 && (
                    <button onClick={() => setPage(page - 1)}>
                        Prev
                    </button>
                )}
                <span>{page} / {totalPages}</span>
                {page < totalPages && (
                    <button onClick={() => setPage(page + 1)}>
                        Next
                    </button>
                )}
            </div>
            </>
        )}
        </>
    )
}