class DataTable{
    elements;
    headers;
    items;
    copyitems;
    selected;
    pagination;
    numberOfEntries;
    headerButtons;

    constructor(selector, headerButtons){
        this.element =documen.querySelector(selector);

        this.headers = [];
        this.items = [];
        this.pagination = {total:0,
        noItemsPerPage: 0, 
        noPages: 0,
        actual: 0,
        pointer: 0,
        diff: 0,
        lastPageBeforeDots: 0,
        noButtonsBeforeDots: 4
        };
    }

    this.selected = [];
    this.numberOfEntries = 5;
    this.headerButtons = headerButtons;
}