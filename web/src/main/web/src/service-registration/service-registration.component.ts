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

  ngOnInit() {
  }
  form = new FormGroup({});
  model = {
    myFAQ: [{}]
  };

  fields: FormlyFieldConfig[] = [
    {
      key: 'serviceName',
      type: 'input',
      templateOptions: {
        label: 'Service Name',
        placeholder: 'Service Name',
        required: true,
      }
    },
    {
      key: 'servicePrice',
      type: 'input',
      templateOptions: {
        type: 'number',
        label: 'Price',
        placeholder: 'Price (ZAR)',
        required: true,
      }
    },
    {
      key: 'serviceType',
      type: 'select',
      templateOptions: {
        label: 'Service Type',
        required: true,
        options: [
          { value: 1, label: 'Option 1' },
          { value: 2, label: 'Option 2' },
          { value: 3, label: 'Option 3' },
          { value: 4, label: 'Option 4' },
        ]
      },

    },
    {
      key: 'servicePricePerUnit',
      type: 'input',
      templateOptions: {
        label: 'Price Per Unit',
        placeholder: 'Price (ZAR)',
        required: true,
      },
      hideExpression: '!model.serviceType'
    },
    {
      key: 'serviceUnits',
      type: 'input',
      templateOptions: {
        label: 'Service Units',
        required: true,
      }
    },
    {
      key: 'what3words',
      type: 'input',
      templateOptions: {
        placeholder: 'What 3 words address'
      }
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
      key: 'coordinates',
      type: 'input',
      templateOptions: {
        label: 'Business Address',
        required: true,
      },
      hideExpression: '!model.remote'
    },
    {
      key: 'myFAQ',
      type: 'faqs',
      templateOptions: {
        addText: 'Add another investment',
      },
      fieldArray: {
        fieldGroup: [
          {
            className: 'col-sm-4',
            type: 'input',
            key: 'investmentName',
            templateOptions: {
              label: 'Name of Investment:',
              required: true,
            },
          },
          {
            type: 'input',
            key: 'investmentDate',
            className: 'col-sm-4',
            templateOptions: {
              type: 'date',
              label: 'Date of Investment:',
            },
          },
          {
            type: 'input',
            key: 'stockIdentifier',
            className: 'col-sm-4',
            templateOptions: {
              label: 'Stock Identifier:',
            },
          },
        ],
      },
    }
  ];

  onSubmit() {
    console.log(this.model);
  }
}
