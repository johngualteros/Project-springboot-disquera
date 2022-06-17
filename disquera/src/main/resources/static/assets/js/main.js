// Eliminar
function deleteCancion(id){
    let idCancion=id;
    const swalWithBootstrapButtons = Swal.mixin({
        customClass: {
            confirmButton: 'btn confirm',
            cancelButton: 'btn cancel'
        },
        buttonsStyling: true
      })
      
      swalWithBootstrapButtons.fire({
        title: 'Are you sure?',
        text: "You won't be able to revert this!",
        icon: 'warning',
        showCancelButton: true,
        confirmButtonText: 'Yes, delete it!',
        cancelButtonText: 'No, cancel!',
        reverseButtons: true
      }).then((result) => {
        if (result.isConfirmed) { 
            swalWithBootstrapButtons.fire(
                'Deleted!',
                'Your file has been deleted.',
                'success'
              ).then((result)=>{
                window.location.href=`delete/${idCancion}`;
            })

        } else if (
          /* Read more about handling dismissals below */
          result.dismiss === Swal.DismissReason.cancel
        ) {
          swalWithBootstrapButtons.fire(
            'Cancelled',
            'Your imaginary file is safe :)',
            'error'
          )
        }
      })
}
function deleteDisquera(id){
    let idDisquera=id;
    const swalWithBootstrapButtons = Swal.mixin({
        customClass: {
            confirmButton: 'btn confirm',
            cancelButton: 'btn cancel'
        },
        buttonsStyling: true
      })
      
      swalWithBootstrapButtons.fire({
        title: 'Are you sure?',
        text: "You won't be able to revert this!",
        icon: 'warning',
        showCancelButton: true,
        confirmButtonText: 'Yes, delete it!',
        cancelButtonText: 'No, cancel!',
        reverseButtons: true
      }).then((result) => {
        if (result.isConfirmed) { 
            swalWithBootstrapButtons.fire(
                'Deleted!',
                'Your file has been deleted.',
                'success'
              ).then((result)=>{
                window.location.href=`delete/${idDisquera}`;
            })

        } else if (
          /* Read more about handling dismissals below */
          result.dismiss === Swal.DismissReason.cancel
        ) {
          swalWithBootstrapButtons.fire(
            'Cancelled',
            'Your imaginary file is safe :)',
            'error'
          )
        }
      })
}
function deleteArtista(id){
    let idArtista=id;
    const swalWithBootstrapButtons = Swal.mixin({
        customClass: {
            confirmButton: 'btn confirm',
            cancelButton: 'btn cancel'
        },
        buttonsStyling: true
      })
      
      swalWithBootstrapButtons.fire({
        title: 'Are you sure?',
        text: "You won't be able to revert this!",
        icon: 'warning',
        showCancelButton: true,
        confirmButtonText: 'Yes, delete it!',
        cancelButtonText: 'No, cancel!',
        reverseButtons: true
      }).then((result) => {
        if (result.isConfirmed) { 
            swalWithBootstrapButtons.fire(
                'Deleted!',
                'Your file has been deleted.',
                'success'
              ).then((result)=>{
                window.location.href=`delete/${idArtista}`;
            })

        } else if (
          /* Read more about handling dismissals below */
          result.dismiss === Swal.DismissReason.cancel
        ) {
          swalWithBootstrapButtons.fire(
            'Cancelled',
            'Your imaginary file is safe :)',
            'error'
          )
        }
      })
}
function deleteGenero(id){
    let idGenero=id;
    const swalWithBootstrapButtons = Swal.mixin({
        customClass: {
            confirmButton: 'btn confirm',
            cancelButton: 'btn cancel'
        },
        buttonsStyling: true
      })
      
      swalWithBootstrapButtons.fire({
        title: 'Are you sure?',
        text: "You won't be able to revert this!",
        icon: 'warning',
        showCancelButton: true,
        confirmButtonText: 'Yes, delete it!',
        cancelButtonText: 'No, cancel!',
        reverseButtons: true
      }).then((result) => {
        if (result.isConfirmed) { 
            swalWithBootstrapButtons.fire(
                'Deleted!',
                'Your file has been deleted.',
                'success'
              ).then((result)=>{
                window.location.href=`delete/${idGenero}`;
            })

        } else if (
          /* Read more about handling dismissals below */
          result.dismiss === Swal.DismissReason.cancel
        ) {
          swalWithBootstrapButtons.fire(
            'Cancelled',
            'Your imaginary file is safe :)',
            'error'
          )
        }
      })
}
function deleteAlbum(id){
    let idAlbum=id;
    const swalWithBootstrapButtons = Swal.mixin({
  customClass: {
    confirmButton: 'btn confirm',
    cancelButton: 'btn cancel'
  },
  buttonsStyling: true
})

swalWithBootstrapButtons.fire({
  title: 'Are you sure?',
  text: "You won't be able to revert this!",
  icon: 'warning',
  showCancelButton: true,
  confirmButtonText: 'Yes, delete it!',
  cancelButtonText: 'No, cancel!',
  reverseButtons: true
}).then((result) => {
  if (result.isConfirmed) {
    swalWithBootstrapButtons.fire(
      'Deleted!',
      'Your file has been deleted.',
      'success'
    ).then((result)=>{
        window.location.href=`delete/${idAlbum}`;
    })
  } else if (
    /* Read more about handling dismissals below */
    result.dismiss === Swal.DismissReason.cancel
  ) {
    swalWithBootstrapButtons.fire(
      'Cancelled',
      'Your imaginary file is safe :)',
      'error'
    )
  }
})
}
// Editar
function editar(){
  let button=document.getElementById('form-edit');
    const swalWithBootstrapButtons = Swal.mixin({
  customClass: {
    confirmButton: 'btn confirm',
    cancelButton: 'btn cancel'
  },
  buttonsStyling: true
  })

  swalWithBootstrapButtons.fire({
  title: 'Are you sure?',
  text: "You won't be able to revert this!",
  icon: 'warning',
  showCancelButton: true,
  confirmButtonText: 'Yes, edit it!',
  cancelButtonText: 'No, cancel!',
  reverseButtons: true
  }).then((result) => {
  if (result.isConfirmed) {
    button.submit()
    swalWithBootstrapButtons.fire(
      'Edited!',
      'Your file has been edited.',
      'success'
    )
  } else if (
    /* Read more about handling dismissals below */
    result.dismiss === Swal.DismissReason.cancel
  ) {
    swalWithBootstrapButtons.fire(
      'Cancelled',
      'Your imaginary file is safe :)',
      'error'
    )
  }
  })
}