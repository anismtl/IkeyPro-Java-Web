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
    xhr.open("GET", "Ajax?action=P", true);
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
                s = $('<li><a href="ListeProduits?cat=' + liste[i].idCategorie + '"> ' + liste[i].categorie + ' <i class="fas fa-chevron-right"></i></a></li>');
                s.appendTo('#cat');
            }



        } else if (this.readyState == 4) {
            alert("Erreur AJAX");
        }
    }
    xhr.open("GET", "Ajax?action=C", true);
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

function chercher() {

    var val1;
    var mailformat = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;
    val1 = document.getElementById("Des").value;

    if (val1.match(mailformat)) {
        alert("Champ Destination est Obligatoire");
    } else {
        document.getElementById("resultat").innerHTML = "salur";
    }
   

    var xhr = new XMLHttpRequest();
    var reponseJSON, liste;
    xhr.onreadystatechange = function () {
        console.log(this);
        if (this.readyState == 4 && this.status == 200) {

            reponseJSON = this.responseText;
            liste = JSON.parse(reponseJSON);
            //alert(liste);

    s = '<a color="red"><b>'+liste+'</b></a> ';
     document.getElementById("resultat").innerHTML = s;

//            document.getElementById("contentPanel").innerHTML = null;
  //          for (i = 0; i < liste.length; i++) {
            
//                var myCol = $(' <div class="col-sm-4"></div>');
//                var myPanel = $('<div class="card bg-light mb-3"><img class="card-img-top" src="' + liste[i].pic + '" alt="Card image cap"><div class="card-body"><h5>Navire: <a> ' + liste[i].Navire + '</a></h5><h6>DurÃ©e: <a> ' + liste[i].duree + ' jours</a></h6><h6>Date DÃ©part : <a> ' + liste[i].date_depart + '</a></h6><h6>Tarif : <a>' + liste[i].tarif + ' $ CAD</a></h6><h6>Port de dÃ©part:<a>' + liste[i].port_depart + '</a></h6><span class="float-center"><button type="button" class="btn btn-primary btn-sm" data-toggle="modal" data-target="#add_new_record_modal" >DÃ©tails</button></span> <span class="float-right"><button type="button" class="btn btn-info btn-sm" >RÃ©server</button></span></div></div>');
//                myPanel.appendTo(myCol);
//                myCol.appendTo('#contentPanel');
//                //--   s += '<tr> <th scope="row">' + liste[i].num + '</th>';
//                //    s += "<td>" + liste[i].destination + "</td>";
//                //   s += "<td>" + liste[i].date_depart + "</td>";
//                //   s += "<td>" + liste[i].duree + "</td>";
//                //   s += "<td>" + liste[i].tarif + "</td>";
//                //   s += "<td>" + liste[i].Navire + "</td>";
//                //  s += "<td>" + liste[i].port_depart + "</td></tr> ";
//                //--
  //          }
           


        }
    }
    xhr.open("POST", "Ajax?action=N&courriel=" + val1, true);
    xhr.send();
}
        