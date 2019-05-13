window.onload = Loading;
//document.getElementById("bChercher").addEventListener("click",chercher);
//document.getElementById("Des").addEventListener("pointerenter",dest_List);
//document.getElementById("Port").addEventListener("pointerenter",port_List);
//document.getElementById("Des").addEventListener("change",port_List);


function Loading() {
    getMostViewProduitList();
    getCategoriesList();
}


function getMostViewProduitList() {

    var xhr = new XMLHttpRequest();
    var reponseJSON, liste, s;
    xhr.onreadystatechange = function () {

        if (this.readyState == 4 && this.status == 200) {

            reponseJSON = this.responseText;
            liste = JSON.parse(reponseJSON);
            //alert(liste);
            s = '<div class="owl-carousel owl-theme viewed_slider" >';
            // v = "";
            for (i = 0; i < liste.length; i++) {

                // s += '<div class="owl-item"><div class="viewed_item d-flex flex-column align-items-center justify-content-center text-center"><div class="viewed_image"><img src="images/'+liste[i].image+'"></div><div class="viewed_content text-center"><div class="viewed_price">$"'+ liste[i].prix + '"</div><div class="viewed_name"><a href="GererProduit?id =' + liste[i].codeProduit + '">' + liste[i].produit + '</a></div></div><li class="item_mark item_discount">-25%</li><li class="item_mark item_new">new</li></ul></div></div></div></div>';


                var v = $('<div class="col-md-2 owl-item"><div class="viewed_item d-flex flex-column align-items-center justify-content-center text-center"><div class="viewed_image"><img src="images/' + liste[i].image + '" alt=""></div><div class="viewed_content text-center"><div class="viewed_price">$' + liste[i].prix + '</div><div class="viewed_name"><a href="GererProduit?id=' + liste[i].codeProduit + '">' + liste[i].produit + '</a></div></div><ul class="item_marks"><li class="item_mark item_discount">-25%</li><li class="item_mark item_new">new</li></ul></div></div>');
                v.appendTo('#des');
            }
            // document.getElementsByClassName("owl-carousel owl-theme viewed_slider").innerHTML=v;
            //  document.getElementById("des").innerHTML=s;

            // port_List();


        } else if (this.readyState == 4) {
            alert("Erreur AJAX");
        }
    }
    xhr.open("POST", "Ajax?action=P", true);
    xhr.send();
}


function getCategoriesList() {

    var xhr = new XMLHttpRequest();
    var reponseJSON, liste, s;
    xhr.onreadystatechange = function () {

        if (this.readyState == 4 && this.status == 200) {

            reponseJSON = this.responseText;
            liste = JSON.parse(reponseJSON);

            for (i = 0; i < liste.length; i++) {
                s = $('<li><a href="ListeProduits?action=categorie&cat=' + liste[i].idCategorie + '"> ' + liste[i].categorie + ' <i class="fas fa-chevron-right"></i></a></li>');
                s.appendTo('#cat');
            }



        } else if (this.readyState == 4) {
            alert("Erreur AJAX");
        }
    }
    xhr.open("POST", "Ajax?action=C", true);
    xhr.send();
}


function port_List() {
    var val = document.getElementById("Des").value;
    var xhr = new XMLHttpRequest();
    var reponseJSON, liste1, s;
    xhr.onreadystatechange = function () {

        if (this.readyState == 4 && this.status == 200) {
            console.log(this);
            reponseJSON = this.responseText;
            liste1 = JSON.parse(reponseJSON);
            s = "<option>---Select---</option> ";
            for (i = 0; i < liste1.length; i++) {
                s += "<option value=" + liste1[i].port_depart + ">" + liste1[i].port_depart + "</option>";
            }

            document.getElementById("Port").innerHTML = s;
        } else if (this.readyState == 4) {
            alert("Erreur AJAX");
        }
    }
    xhr.open("GET", "getPort.php?dest=" + val, true);
    xhr.send();
}

        