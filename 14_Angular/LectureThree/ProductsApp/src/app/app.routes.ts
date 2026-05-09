import { Routes } from '@angular/router';
import { ProductsComponent } from './products-component/products-component';
import { Productcomponent } from './product-component/productcomponent';
import { LoginComponent } from './login-component/login-component';
import { SignupComponent } from './signup-component/signup-component';
import { CartComponent } from './cart-component/cart-component';
import { NotFoundComponent } from './not-found-component/not-found-component';
import { ProductDetails } from './product-details/product-details';
export const routes: Routes = [
    {path:'',redirectTo:'/products',pathMatch:'full'},
    {path:'products',component: ProductsComponent},
    {path:'products/:id',component:ProductDetails},
    { path: 'login', component: LoginComponent },
    { path: 'signup', component: SignupComponent },
    { path: 'cart', component: CartComponent },
    { path: '404', component: NotFoundComponent },
    { path: '**', redirectTo: '/404' }
];
