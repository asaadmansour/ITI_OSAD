import { useSelector } from "react-redux";
import { useContext } from "react";
import NavBar from "../../components/nav-bar/NavBar";
import ProductCart from "../../components/product-cart/ProductCart";
import { selectTotalQuantity, selectTotalPrice } from "../../store/slices/cartSlicer";
import LanguageContext from "../../store/../contexts/languageContext";

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

const translations = {
  en: {
    title: "Shopping Cart",
    orderSummary: "Order Summary",
    totalProducts: "Total Products",
    shipping: "Shipping",
    free: "Free",
    total: "Total",
    checkout: "Checkout",
  },
  ar: {
    title: "سلة التسوق",
    orderSummary: "ملخص الطلب",
    totalProducts: "إجمالي المنتجات",
    shipping: "الشحن",
    free: "مجاني",
    total: "الإجمالي",
    checkout: "إتمام الشراء",
  },
};

export default function Cart() {
    const items = useSelector((state) => state.cart.items);
    const totalQuantity = useSelector(selectTotalQuantity);
    const totalMoney = useSelector(selectTotalPrice);
    const { language } = useContext(LanguageContext);
    const t = translations[language] ?? translations.en;
    const isAr = language === "ar";

  return (
    <>
      <NavBar />
      <div dir={isAr ? "rtl" : "ltr"} className="min-h-screen bg-gray-50 pt-16 px-4 py-10">
        <div className="max-w-5xl mx-auto">

          <h1 className="text-2xl font-bold text-gray-800 mb-8">{t.title}</h1>

          <div className="flex flex-col lg:flex-row gap-8">

            {/* Cart Items */}
            <div className="flex-1 flex flex-col gap-4 bg-slate-100">
              {items.map((item) => (
                <ProductCart key={item.id} item={item} />
              ))}
            </div>

            {/* Order Summary */}
            <div className="w-full lg:w-72 shrink-0">
              <div className="bg-white rounded-2xl shadow-sm p-6 flex flex-col gap-4">
                <h2 className="text-base font-bold text-gray-800">{t.orderSummary}</h2>

                <div className="flex flex-col gap-2 text-sm text-gray-500">
                  <div className="flex justify-between">
                    <span>{t.totalProducts}</span>
                    <span className="font-medium text-gray-800">{totalQuantity}</span>
                  </div>
                  <div className="flex justify-between">
                    <span>{t.shipping}</span>
                    <span className="font-medium text-green-500">{t.free}</span>
                  </div>
                </div>

                <div className="border-t border-gray-100 pt-3 flex justify-between text-sm font-bold text-gray-800">
                  <span>{t.total}</span>
                  <span className="text-blue-500">${Math.ceil(totalMoney)}</span>
                </div>

                <button className="w-full bg-blue-500 hover:bg-blue-500 text-white text-sm font-semibold py-2.5 rounded-xl transition-colors">
                  {t.checkout}
                </button>
              </div>
            </div>

          </div>
        </div>
      </div>
    </>
  );
}
