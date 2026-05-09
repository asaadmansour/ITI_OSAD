export default function CartItem({ item }) {
  return (
    <div className="bg-white rounded-2xl shadow-sm flex items-center gap-5 p-4">
      <div className="bg-gray-100 rounded-xl flex items-center justify-center w-24 h-24 shrink-0">
        <img
          src={item.thumbnail}
          alt={item.title}
          className="h-full object-contain p-2"
        />
      </div>

      <div className="flex-1 min-w-0">
        <p className="text-sm font-semibold text-gray-800 line-clamp-2">
          {item.title}
        </p>
        <p className="text-xs text-gray-400 mt-0.5">{item.category}</p>
      </div>

      <div className="flex flex-col items-end gap-2 shrink-0">
        <span className="text-sm font-bold text-indigo-600">${item.price}</span>
        <div className="flex items-center gap-2">
          <button className="w-7 h-7 rounded-lg bg-gray-100 text-gray-600 font-bold text-sm flex items-center justify-center">
            −
          </button>
          <span className="text-sm font-semibold text-gray-700 w-5 text-center">
            {item.quantity}
          </span>
          <button className="w-7 h-7 rounded-lg bg-gray-100 text-gray-600 font-bold text-sm flex items-center justify-center">
            +
          </button>
        </div>
        <button className="text-xs text-red-400 font-medium">Remove</button>
      </div>
    </div>
  );
}
