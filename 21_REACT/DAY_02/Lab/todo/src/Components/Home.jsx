import { useState } from 'react'
import Search from './AddTask'
import Results from './Results'

export default function Home() {
  const [todos, setTodos] = useState([])

  function addTodo(text) {
    if (!text.trim()) return
    setTodos([...todos, { id: Date.now(), title: text, done: false }])
  }
  function deleteTodo(id) {
    const filtered = todos.filter(todo => todo.id != id)
    setTodos(filtered)
  }
  function toggleTodo(id) {
    setTodos(todos.map(todo => todo.id === id ? { ...todo, done: !todo.done } : todo))
  }
  return (
    <div className="max-w-xl mx-auto px-4 py-10">
      <h1 className="text-2xl font-bold mb-6">My Todos</h1>
      <Search onAddTodo={addTodo} />
      <Results todos={todos} onDeleteTodo={deleteTodo} onToggleTodo={toggleTodo}/>
    </div>
  )
}