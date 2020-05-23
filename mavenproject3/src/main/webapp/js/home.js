(function () {
  function initItems() {
    var itemList = [];
    var xhr = new XMLHttpRequest();
    xhr.open("GET","api/loaddata",true);
    xhr.send();
    xhr.onreadystatechange = function() {
      if (xhr.readyState == 4 && xhr.status == 200){
        itemList = JSON.parse(xhr.responseText);
        
        var list = document.getElementById("listOfItem");   
        
        itemList.forEach(element => {
          
          var iDiv = document.createElement('div');
          iDiv.className = 'col-4 col-s-6';
          iDiv.id = element.id;
          list.appendChild(iDiv);

          var link = document.createElement('a');
          
          link.href = 'product.html?product=' + element.name;
          iDiv.appendChild(link)
          link.addEventListener('click', function() { 
              localStorage.setItem('product', JSON.stringify(element))
          }, false);

          var image = document.createElement('img');
          image.className = "thumbnail";
          image.src = "picture/" + element.imgHref;
          image.style = "width:300px;height:350px;";
          link.appendChild(image)

          var title = document.createElement('h3');
          iDiv.appendChild(title)

          var link2 = document.createElement('a');
          link2.href = 'product.html?product=' + element.name;
          link2.appendChild(document.createTextNode(element.name))
          title.appendChild(link2)
          link2.addEventListener('click', function() { 
              localStorage.setItem('product', JSON.stringify(element))
          }, false);

          var desc = document.createElement('p');
          desc.appendChild(document.createTextNode(element.description))
          iDiv.appendChild(desc);
      });
 };   
  }
    
  }

  document.onreadystatechange = () => {
    if (document.readyState === 'complete') {
      initItems();
    }
  };

})();