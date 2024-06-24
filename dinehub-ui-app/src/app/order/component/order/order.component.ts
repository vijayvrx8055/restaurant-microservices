import { Component } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { MdbModalRef, MdbModalService } from 'mdb-angular-ui-kit/modal';
import { FoodCataloguePage } from '../../../shared/models/food-catalogue-page';
import { OrderDTO } from '../../model/order-dto';
import { OrderService } from '../../service/order.service';
import { ConfirmationModalComponent } from '../confirmation-modal/confirmation-modal.component';

@Component({
  selector: 'app-order',
  templateUrl: './order.component.html',
  styleUrl: './order.component.css'
})
export class OrderComponent {

  orderSummary: OrderDTO;
  obj: any;
  order: FoodCataloguePage;
  total: any;
  showDialog: boolean = false;

  modalRef: MdbModalRef<ConfirmationModalComponent> | null = null;

  constructor(private route: ActivatedRoute,
    private orderService: OrderService,
    private router: Router,
    private modalService: MdbModalService) { }

  ngOnInit() {
    const data = this.route.snapshot.queryParams['data'];
    this.obj = JSON.parse(data);
    console.log(this.order);

    this.obj.userId = 1;
    this.orderSummary = this.obj;

    this.total = this.orderSummary.foodItemsList.reduce((accumulator, currentValue) => {
      return accumulator + (currentValue.quantity * currentValue.price);
    }, 0);

  }

  saveOrder() {
    this.orderService.saveOrder(this.orderSummary)
      .subscribe(
        response => {
          this.showDialog = true;
          this.openModal();
        }
      );
  }

  openModal() {
    this.modalRef = this.modalService.open(ConfirmationModalComponent)
  }

  closeDialog() {
    this.showDialog = false;
    this.router.navigate(['/']); // Replace '/home' with the actual route for your home page
  }
}
