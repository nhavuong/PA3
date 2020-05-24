
function generatePage(resultdata){
    let list = document.getElementById("listOfItem"); 
    let resultJson = JSON.parse(resultdata);
    resultJson.forEach(element => {
        var iDiv = document.createElement('div');
        iDiv.className = 'col-4 col-s-6';
        iDiv.id = element.id;
        list.appendChild(iDiv);

        var link = document.createElement('a');

        link.href = 'product.html?product=' + element.name;
        iDiv.appendChild(link);

        var image = document.createElement('img');
        image.className = "thumbnail";
        image.src = "picture/" + element.imgHref;
        image.style = "width:300px;height:350px;";
        link.appendChild(image);

        var title = document.createElement('h3');
        iDiv.appendChild(title);

        var link2 = document.createElement('a');
        link2.href = 'product.html?product=' + element.name;
        link2.appendChild(document.createTextNode(element.name));
        title.appendChild(link2);
        var desc = document.createElement('p');
        desc.appendChild(document.createTextNode(element.description));
        iDiv.appendChild(desc);
        
    });
    
}

//function generateVisisted(resultdata){
//    let visistedContainer = document.getElementById("viewedItem");
//    let products = JSON.parse(resultdata);
//    for(let i = 0; i < products.length; i++){
//        lastProduct = products[i]["name"];                
//        lastImghref = products[i]["imgHref"];
//
//        var iDiv = document.createElement('div');
//        iDiv.className = 'col-2';
//        visistedContainer.appendChild(iDiv);
//
//        var linkview = document.createElement('a');   
//
//        linkview.href = 'product.html?product=' + products[i]["name"];
//        iDiv.appendChild(linkview);
//
//        var imageViewed = document.createElement('img');
//        imageViewed.src = "picture/" + products[i]["imgHref"];
//        imageViewed.style = "width:200px;height:250px;";
//        linkview.appendChild(imageViewed);
//
//        var title = document.createElement('h3');
//        iDiv.appendChild(title);
//
//        var link2 = document.createElement('a');
//        link2.href = 'product.html?product=' + products[i]["name"];
//        link2.appendChild(document.createTextNode(products[i]["name"]));
//        title.appendChild(link2);
//    }
//}

jQuery.ajax({
    method: "get",
    url: "api/loaddata",
    success: resultdata => generatePage(resultdata)
})
let totalProducts = 0;
for(let i = 0; i < localStorage.length; i++){
    console.log(localStorage.key(i));
    totalProducts += parseInt(localStorage.getItem(localStorage.key(i)));
}
document.querySelector('.cart-update span').textContent = totalProducts;

