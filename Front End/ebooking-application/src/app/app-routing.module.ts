import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AdminComponent } from './pages/admin/admin.component';
import { AllordersComponent } from './pages/allorders/allorders.component';
import { EventsComponent } from './pages/events/events.component';
import { HomeComponent } from './pages/home/home.component';
import { LoginComponent } from './pages/login/login.component';
import { OrderComponent } from './pages/order/order.component';
import { OrdersListComponent } from './pages/orders-list/orders-list.component';
import { SignupComponent } from './pages/signup/signup.component';
import { UserComponent } from './pages/user/user.component';

const routes: Routes = [

  {
    path: '',
    component: HomeComponent,
    pathMatch: 'full'
  },

  {
    path: 'signup',
    component: SignupComponent,
    pathMatch: 'full'
  },

  {
    path: 'create_events',
    component: EventsComponent,
    pathMatch: 'full'
  },

  {
    path: 'login',
    component: LoginComponent,
    pathMatch: 'full'
  },

  {
    path : 'order',
    component : OrderComponent,
    pathMatch : 'full'
  },

  {
    path : 'view_orders',
    component : AllordersComponent,
    pathMatch : 'full'
  },

  {
    path : 'admin',
    component : AdminComponent,
    pathMatch : 'full'
  },

  {
    path : 'orders/:userId',
    component : OrdersListComponent,
    pathMatch : 'full'
  },

  {
    path : 'user',
    component : UserComponent,
    pathMatch : 'full'
  }

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
