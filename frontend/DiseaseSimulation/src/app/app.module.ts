import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { SirComponentComponent } from './simulation-components/sir-component/sir-component.component';
import { SeirdsComponentComponent } from './simulation-components/seirds-component/seirds-component.component';
import { HttpClientModule } from '@angular/common/http';
import { SeirdsChartComponent } from './simulation-components/seirds-component/seirds-chart/seirds-chart.component';
import { SirChartComponent } from './simulation-components/sir-component/sir-chart/sir-chart.component';
import { SeirdsAddDialogComponent } from './simulation-components/seirds-component/seirds-add-dialog/seirds-add-dialog.component';
import { MatDialogModule } from '@angular/material/dialog';
import { MatFormFieldModule } from '@angular/material/form-field';
import { ReactiveFormsModule } from '@angular/forms';
import { MatInputModule } from '@angular/material/input'
import { MatButtonModule } from '@angular/material/button'
import { MatIconModule } from '@angular/material/icon';
import { SeirdsUpdateDialogComponent } from './simulation-components/seirds-component/seirds-update-dialog/seirds-update-dialog.component';

@NgModule({
  declarations: [
    AppComponent,
    SirComponentComponent,
    SeirdsComponentComponent,
    SeirdsChartComponent,
    SirChartComponent,
    SeirdsAddDialogComponent,
    SeirdsUpdateDialogComponent,
  ],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    HttpClientModule,
    MatDialogModule,
    MatFormFieldModule,
    ReactiveFormsModule,
    MatInputModule,
    MatButtonModule,
    MatIconModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
