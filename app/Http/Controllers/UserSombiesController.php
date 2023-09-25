<?php

namespace App\Http\Controllers;

use App\Models\user_sombies;
use Illuminate\Http\Request;

class UserSombiesController extends Controller
{

    public function index()
    {
        //
    }


    public function createZom()
    {
        return view('UserZombie.formZombie');
    }

    public function saveZom(Request $request)
    {
        $user = $this->validate($request, [
            "name"      => "required",
            "email"    => "required|string|email",
            "password"    => "required",
            "image"    => "required",

        ]);

        //Guardar la foto
        if($request->hasFile('image')){
            $user['image']=$request->file("image")->store('uploads', 'public');
        }

        user_sombies::create([
            "name"     => $user["name"],
            "points"   => 0, //se inicializa con 0 el conteo
            "email"    => $user["email"],
            "password"   => $user["password"],
            "dateZ"   => now(), //para la fecha
            "image"   => $user["image"],
        ]);

        return redirect('/')->with('Guardado', "Usuario Guardado");
    }

    public function edit(user_sombies $user_sombies)
    {
        //
    }

    public function update(Request $request, user_sombies $user_sombies)
    {
        //
    }

    public function destroy(user_sombies $user_sombies)
    {
        //
    }
}
