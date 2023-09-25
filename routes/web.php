<?php

use App\Http\Controllers\UserSombiesController;
use Illuminate\Support\Facades\Route;

/*
|--------------------------------------------------------------------------
| Web Routes
|--------------------------------------------------------------------------
|
| Here is where you can register web routes for your application. These
| routes are loaded by the RouteServiceProvider and all of them will
| be assigned to the "web" middleware group. Make something great!
|
*/

Route::get('/', function () {
    return view('UserZombie/viewZombie');
});

//Visualizar la lista de usuario
Route::get('/', [UserSombiesController::class, 'index'])->name('index');
//Agregar usuario
Route::get('/formUser', [UserSombiesController::class, 'createZom'])->name('createZom');
//Guardar usuario
Route::post('/saveUser', [UserSombiesController::class, 'saveZom'])->name('zombie.saveZom');
