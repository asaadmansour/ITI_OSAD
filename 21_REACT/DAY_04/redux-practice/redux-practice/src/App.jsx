import { useSelector, useDispatch } from "react-redux";
import { toggleTheme } from "./store/slices/themeSlice";

export default function App() {
  const theme = useSelector((state) => state.theme.mode);
  const dispatch = useDispatch();

  return (
    <button onClick={() => dispatch(toggleTheme())}>
      Toggle Theme ({theme})
    </button>
  );
}