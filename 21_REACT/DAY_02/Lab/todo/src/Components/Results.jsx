import Card from './Card'

export default function Results({ todos, onDeleteTodo, onToggleTodo }) {
  return (
    <ul className="flex flex-col gap-2">
      {todos.map((todo) => (
        <li key={todo.id}>
          <Card todo={todo} onDelete={() => onDeleteTodo(todo.id)} onToggle={() => onToggleTodo(todo.id)} />
        </li>
      ))}
    </ul>
  )
}