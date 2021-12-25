$(document).ready( function () {
    table = $('.list-building table').DataTable({
        "dom": '<tip>'
    });
    $('.filter .filter-field .filter-field-input').keyup(function(){
        table.search($(this).val()).draw() ;
    })
} );