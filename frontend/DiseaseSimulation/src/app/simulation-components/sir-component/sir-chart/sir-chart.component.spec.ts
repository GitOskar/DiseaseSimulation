import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SirChartComponent } from './sir-chart.component';

describe('SirChartComponent', () => {
  let component: SirChartComponent;
  let fixture: ComponentFixture<SirChartComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ SirChartComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(SirChartComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
