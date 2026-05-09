import NavBar from "../../components/nav-bar/NavBar";
import CartItem from "./CartItem";

const cartItems = [
  {
    id: 1,
    title: "Essence Mascara Lash Princess",
    category: "Beauty",
    price: 9.99,
    quantity: 1,
    thumbnail:
      "https://cdn.dummyjson.com/products/images/beauty/Essence%20Mascara%20Lash%20Princess/thumbnail.webp",
  },
  {
    id: 2,
    title: "Chanel Coco Noir Eau De",
    category: "Fragrances",
    price: 550.0,
    quantity: 2,
    thumbnail:
      "https://cdn.dummyjson.com/products/images/fragrances/Chanel%20Coco%20Noir%20Eau%20De/thumbnail.webp",
  },
  {
    id: 3,
    title: "Annibale Colombo Bed",
    category: "Furniture",
    price: 1899.99,
    quantity: 1,
    thumbnail:
      "https://cdn.dummyjson.com/products/images/furniture/Annibale%20Colombo%20Bed/thumbnail.webp",
  },
];

export default function Cart() {
  return (
    <>
      <NavBar />
      <div className="min-h-screen bg-gray-50 pt-16 px-4 py-10">
        <div className="max-w-5xl mx-auto">

          <h1 className="text-2xl font-bold text-gray-800 mb-8">Shopping Cart</h1>

          <div className="flex flex-col lg:flex-row gap-8">

            {/* Cart Items */}
            <div className="flex-1 flex flex-col gap-4">
              {cartItems.map((item) => (
              <CartItem key={item.id} item={item} />
            ))}
            </div>

            {/* Order Summary */}
            <div className="w-full lg:w-72 shrink-0">
              <div className="bg-white rounded-2xl shadow-sm p-6 flex flex-col gap-4">
                <h2 className="text-base font-bold text-gray-800">Order Summary</h2>

                <div className="flex flex-col gap-2 text-sm text-gray-600">
                  <div className="flex justify-between">
                    <span>Subtotal</span>
                    <span className="font-medium text-gray-800">$2,459.98</span>
                  </div>
                  <div className="flex justify-between">
                    <span>Shipping</span>
                    <span className="font-medium text-green-600">Free</span>
                  </div>
                </div>

                <div className="border-t border-gray-100 pt-3 flex justify-between text-sm font-bold text-gray-800">
                  <span>Total</span>
                  <span className="text-indigo-600">$2,459.98</span>
                </div>

                <button className="w-full bg-indigo-600 hover:bg-indigo-700 text-white text-sm font-semibold py-2.5 rounded-xl transition-colors">
                  Checkout
                </button>
              </div>
            </div>

          </div>
        </div>
      </div>
    </>
  );
}
