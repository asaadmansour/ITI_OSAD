import { useState } from 'react'

export default function Search({ onAddTodo }) {
  const [input, setInput] = useState('')

  function handleAdd() {
    onAddTodo(input)
    setInput('')
  }
  return (
    <div className="flex gap-2 mb-4">
      <input
        type="text"
        value={input}
        placeholder="Add a new task..."
        className="flex-1 border border-gray-300 rounded px-3 py-2 text-sm outline-none focus:border-blue-400"
        onChange={(e) => setInput(e.target.value)}
      />
      <button
        onClick={handleAdd}
        className="bg-blue-500 hover:bg-blue-600 text-white text-sm px-4 py-2 rounded"
      >
        Add
      </button>
    </div>
  )
}