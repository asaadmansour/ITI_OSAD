import { configureStore } from "@reduxjs/toolkit";
import cartReducer from "./slices/cartSlicer"
const store = configureStore({
    reducer: {
        cart: cartReducer,
    },
})

export default store