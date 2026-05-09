import { createSlice } from "@reduxjs/toolkit";
const cartInitialState = {
    items : []
}
const cartSlicer = createSlice({
    name: "cart",
    initialState: cartInitialState,
    reducers: {
        addProduct: (state,action)=> {
            const exisiting = state.items.find((item) => item.id === action.payload.id)
            if(exisiting) 
                exisiting.quantity += action.payload.quantity
            else 
                state.items.push(action.payload)
        },
        removeProduct: (state, action) => {
        state.items = state.items.filter(item => item.id !== action.payload.id);
        },
        updateQuantity: (state, action) => {
        const product = state.items.find(item => item.id === action.payload.id);
        if (!product) return;
        const newQuantity = product.quantity + action.payload.quantity;

        if (newQuantity <= 0) {
            state.items = state.items.filter(item => item.id !== action.payload.id);
            return;
        }
        product.quantity = newQuantity;
        }
    }
})
export default cartSlicer.reducer;
export const selectTotalQuantity = (state) =>
    state.cart.items.reduce((sum, item) => sum + item.quantity, 0);

export const selectTotalPrice = (state) =>
    state.cart.items.reduce((sum, item) => sum + item.price * item.quantity, 0);
export const {addProduct,removeProduct, updateQuantity} = cartSlicer.actions