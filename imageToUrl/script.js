const fileInput = document.getElementById('select-image');
const profile = document.getElementById('profile');
const caption=document.querySelector('.caption');

// Lister to the change event on the <input> element
fileInput.addEventListener('change', (event) => {
    // Get the selected image file
    const imageFile = event.target.files[0];

    if (imageFile) {
        const reader = new FileReader();

        // Convert the image file to a string
        reader.readAsDataURL(imageFile);

        // FileReader will emit the load event when the data URL is ready
        // Access the string using result property inside the callback function
        reader.addEventListener('load', () => {
            // Get the data URL string
            console.log(reader.result);
            localStorage.setItem("imageUrl",reader.result)
            let item=localStorage.getItem('imageUrl');
            profile.src=item;
        });
    }
});
if(localStorage.getItem('imageUrl')){
    profile.src=localStorage.getItem('imageUrl')
}
fileInput.addEventListener('mouseover',()=>{
    caption.style.display="block"
})
fileInput.addEventListener('mouseout',()=>{
    caption.style.display="none"
})
