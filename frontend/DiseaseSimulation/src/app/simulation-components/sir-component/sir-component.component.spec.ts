import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SirComponentComponent } from './sir-component.component';

describe('SirComponentComponent', () => {
  let component: SirComponentComponent;
  let fixture: ComponentFixture<SirComponentComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ SirComponentComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(SirComponentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
