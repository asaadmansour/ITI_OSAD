import { Link } from "react-router-dom";

export default function ProductCard({ details }) {
  return (
    <div className="bg-white rounded-2xl shadow-sm hover:shadow-md transition-shadow duration-300 overflow-hidden flex flex-col">
      <Link to={`/products/${details.id}`}>
        <div className="bg-gray-100 flex items-center justify-center p-6 h-48">
          <img
            src={details?.thumbnail}
            alt={details?.title}
            className="h-full object-contain"
          />
        </div>
        <div className="p-4 flex flex-col gap-2 flex-1">
          <div className="flex items-start justify-between gap-2">
            <p className="text-sm font-semibold text-gray-800 leading-snug line-clamp-2">
              {details?.title}
            </p>
            <span className="text-sm font-bold text-indigo-600 whitespace-nowrap">
              ${details?.price}
            </span>
          </div>
          <p className="text-xs text-gray-400 leading-relaxed line-clamp-2">
            {details?.description}
          </p>
          <div className="flex items-center gap-1 text-amber-400 text-xs">
            {"★".repeat(Math.round(details?.rating ?? 0))}
            <span className="text-gray-300">
              {"★".repeat(5 - Math.round(details?.rating ?? 0))}
            </span>
            <span className="text-gray-400 ml-1">({details?.rating})</span>
          </div>
          <button className="mt-auto w-full bg-indigo-600 hover:bg-indigo-700 text-white text-xs font-semibold py-2 rounded-xl transition-colors">
            Add to Cart
          </button>
        </div>
      </Link>
    </div>
  );
}