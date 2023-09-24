<?php

namespace App\Models;

use Illuminate\Database\Eloquent\Factories\HasFactory;
use Illuminate\Database\Eloquent\Model;

class user_sombies extends Model
{
    use HasFactory;

    public $table='sombies';

    public $timestamps=false;
    protected $fillable=[
        'id','name','points','email', 'password','dateZ', 'image',
    ];

    protected $primaryKey='id';
}
