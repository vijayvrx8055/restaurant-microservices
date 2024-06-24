import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FoodCatalogueComponent } from './food-catalogue.component';

describe('FoodCatalogueComponent', () => {
  let component: FoodCatalogueComponent;
  let fixture: ComponentFixture<FoodCatalogueComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [FoodCatalogueComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(FoodCatalogueComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
