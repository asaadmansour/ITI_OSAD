export default function Card({ todo, onDelete, onToggle }) {
  return (
    <div className={`border rounded px-4 py-3 flex justify-between items-center ${todo.done ? "bg-green-50 border-green-300" : "bg-white border-gray-200"}`}>
      <span className={`text-sm ${todo.done ? "line-through text-gray-400" : "text-gray-800"}`}>{todo.title}</span>
      <div className="flex gap-2">
        <button onClick={onToggle} className="text-green-500 text-xs hover:text-green-700">{todo.done ? "Undo" : "Done"}</button>
        <button onClick={onDelete} className="text-red-400 text-xs hover:text-red-600">Delete</button>
      </div>
    </div>
  )
}
