
export interface OrdersIntf{
    orderId : number;
    orderStatus : string;
    orderDate : Date;
    ticketCategory : string;
    ticketPrice : number;
    ticketQuantity : number;
    promoCodeDiscount : number;
    eventId : number;
    userId : number;
}