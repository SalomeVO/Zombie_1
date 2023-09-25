<?php

namespace App\Http\Controllers;

use App\Models\user_sombies;
use Illuminate\Http\Request;

class UserSombiesController extends Controller
{

    public function index()
    {
        $user = user_sombies::all();//el numero de filas
        return view('UserZombie.viewZombie', compact("user"));
    }


    public function createZom()
    {
        return view('UserZombie.formZombie');
    }

    public function saveZom(Request $request)
    {
        $media = request()->except('_token');

        $user = $this->validate($request, [
            "name"      => "required",
            "email"    => "required|string|email",
            "password"    => "required",
            "image"    => "required|image",

        ]);

        //Guardar la foto
        if($request->hasFile('image')){
            $media['image']=$request->file("image")->store('uploads', 'public');
        }

        user_sombies::create([
            "name"     => $user["name"],
            "points"   => 0, //se inicializa con 0 el conteo
            "email"    => $user["email"],
            "password"   => $user["password"],
            "dateZ"   => now(), //para la fecha
            "image"   => $media["image"],
        ]);

        return redirect('/')->with('usuarioGuardado', "Guardado");
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
