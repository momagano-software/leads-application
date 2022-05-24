import { Component, OnInit } from '@angular/core';
import { FormGroup } from '@angular/forms';
import { FormlyFieldConfig } from '@ngx-formly/core';
@Component({
  selector: 'app-service-registration',
  templateUrl: './service-registration.component.html',
  styleUrls: ['./service-registration.component.css']
})
export class ServiceRegistrationComponent implements OnInit {

  constructor() { }


  // todo: write service to fetch look up values from the backend; update value on options
  // todo: asynch calls for the lookup options
  // todo: combo will be lookup using store id and services previously captured; field array
  

  ngOnInit() {
  }
  form = new FormGroup({});
  model = {
    myFAQ: [{}]
  };

  fields: FormlyFieldConfig[] = [

    {
      key: 'serviceCatergory',
      type: 'select',
      templateOptions: {
        label: 'Category',
        required: true,
        options: [
          { value: 1, label: 'Beauty' },
          { value: 2, label: 'Domestic Cleaning' },
          { value: 3, label: 'Commercial Cleaning' }
        ]
      },
    },
    {
      key: 'serviceSubCatergory',
      type: 'select',
      templateOptions: {
        label: 'Sub-category',
        required: true,
        options: [
          { value: 1, label: 'Hairdressing' },
          { value: 2, label: 'Make up' }
        ]
      },
    },
    {
      key: 'serviceName',
      type: 'select',
      templateOptions: {
        label: 'Service Name',
        required: true,
        options: [
          { value: 1, label: 'Hair Wash' },
          { value: 2, label: 'Hair Dye' },
          { value: 3, label: 'Installation' }
        ]
      },
    },
    {
      key: 'servicePrice',
      type: 'input',
      templateOptions: {
        label: 'Price',
        placeholder: 'Price (ZAR)',
        required: true,
      },
      hideExpression: '!model.serviceName'
    },
    {
      key: 'ownHairPiece',
      type: 'radio',
      templateOptions: {
        label: 'Own Hair Piece',
        required: true,
        options: [
          {value: true, label: 'Yes'},
          {value: false, label: 'No'}
        ]
      },
      hideExpression: `model.serviceName !== 3`
    },
    {
      key: 'optionDiscount',
      type: 'input',
      templateOptions: {
        type: 'number',
        label: 'Discount',
        placeholder: 'Price (ZAR)',
        required: true,
      },
      hideExpression: '!model.ownHairPiece'
    },
    {
      key: 'serviceType',
      type: 'select',
      templateOptions: {
        label: 'Hair Type',
        required: true,
        options: [
          { value: 1, label: 'Braids' },
          { value: 2, label: 'Wig' }
        ]
      },

    },
    {
      key: 'serviceUnits',
      type: 'select',
      templateOptions: {
        label: 'Length',
        required: true,
        options: [
          { value: 1, label: 'Inches' },
          { value: 2, label: 'Millimeters' }
        ]
      },

    },
    {
      key: 'remote',
      type: 'radio',
      templateOptions: {
        label: 'Remote service',
        required: true,
        options: [
          {value: true, label: 'Yes'},
          {value: false, label: 'No'}
        ]
      }
    },
    {
      key: 'businessAddress',
      type: 'input',
      templateOptions: {
        label: 'Business Address',
        required: true,
      },
      hideExpression: '!model.remote'
    },
    {
      key: 'serviceCallOutFee',
      type: 'input',
      templateOptions: {
        label: 'Callout Fee',
        placeholder: 'Price (ZAR)',
        required: true,
      },
      hideExpression: '!model.remote'
    },
    {
      key: 'maximumCallOutRadius',
      type: 'input',
      templateOptions: {
        type: 'number',
        label: 'Maximum Radius',
        placeholder: 'Distance (km)',
        required: true,
      }
    },
    {
      key: 'myFAQ',
      type: 'faqs',
      templateOptions: {
        addText: 'Add FAQ',
      },
      fieldArray: {
        fieldGroup: [
          {
            className: 'col-sm-4',
            type: 'input',
            key: 'question',
            templateOptions: {
              label: 'Question:',
              required: true,
            },
          },
          {
            type: 'input',
            key: 'answer',
            className: 'col-sm-4',
            templateOptions: {
              required: true,
              label: 'Answer:',
            },
          },
        ],
      },
    },
  ];

  onSubmit() {
    console.log(this.model);
  }
}
